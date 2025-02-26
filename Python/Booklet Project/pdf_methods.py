from PyPDF2 import PdfReader, PdfWriter, Transformation, PageObject, PaperSize
from PyPDF2.generic import RectangleObject
from pdf2image import convert_from_path
from os import remove
import os

def resize_pdf_A5(pdf_path, output_path, add_pages):
    pdf_reader = PdfReader(pdf_path)
    writer = PdfWriter()

    #First, rescale document:
    num_pages = len(pdf_reader.pages)

    for i in range(num_pages):
        page = pdf_reader.pages[i]

        A5_w = PaperSize.A5.width
        A5_h = PaperSize.A5.height

        h = float(page.mediabox.height)
        w = float(page.mediabox.width)

        scale_file = min(A5_h/h,A5_w/w)

        #Page transformation
        transform = Transformation().scale(scale_file,scale_file).translate((A5_w-scale_file*w)/2,(A5_h-scale_file*h)/2)
        page.add_transformation(transform)
        page.cropbox = RectangleObject((0, 0, A5_w, A5_h))

        #Prepare A5 blank page
        page_A5 = PageObject.create_blank_page(width = A5_w, height = A5_h)
        page.mediabox = page_A5.mediabox
        #Merge both pages
        page_A5.merge_page(page)
        writer.add_page(page_A5)

        #Show completion
        print(str(int(100*i/num_pages))+'%')
    
    #In case we need to add some more pages

    if add_pages:
        print('Adding pages')
        num_pages = num_pages % 4
        while num_pages % 4 != 0:
            A5_w = PaperSize.A5.width
            A5_h = PaperSize.A5.height
            page_A5 = PageObject.create_blank_page(width = A5_w, height = A5_h)
            writer.add_page(page_A5)
            num_pages += 1

    writer.write(output_path)
    print('Finished reescaling and/or adding pages')
    return 0;

def prepare_print(pdf_path, output_path, size_booklet):
    #Auxiliar path to generate resized and correct number of pages for pdf
    aux_path = '/home/cristoalvarado/aux_1.pdf'
    resize_pdf_A5(pdf_path, aux_path, 1)
    
    #Now we open auxiliar pdf with extra pages
    pdf_reader = PdfReader(aux_path)
    
    #Number of pages to generate booklet
    num_pages = len(pdf_reader.pages)

    #Obtain rearranged pages
    arranged_pages = array_pages(num_pages,size_booklet)

    #Now we create final PDF ready to print
    writer = PdfWriter()
    A4_w = PaperSize.A4.width
    A4_h = PaperSize.A4.height
    for i in range(int(len(arranged_pages)/2)):
        page_A4 = PageObject.create_blank_page(width = A4_w, height = A4_h)
        page_1 = pdf_reader.pages[arranged_pages[2*i] - 1]
        page_2 = pdf_reader.pages[arranged_pages[2*i + 1] - 1]
        page_1.mediabox = page_A4.mediabox
        page_2.mediabox = page_A4.mediabox
        #Odd page, rotate clokwise 90°
        if i % 2 == 1:
            page_1.add_transformation(Transformation().rotate(90))
            page_1.add_transformation(Transformation().translate(A4_w,A4_h/2))
            page_2.add_transformation(Transformation().rotate(90))
            page_2.add_transformation(Transformation().translate(A4_w,0))
        #Even page, rotate clokwise -90°
        else:
            page_2.add_transformation(Transformation().rotate(-90))
            page_2.add_transformation(Transformation().translate(0,A4_h))
            page_1.add_transformation(Transformation().rotate(-90))
            page_1.add_transformation(Transformation().translate(0,A4_h/2))
        #Now merge pages in page_A4
        page_A4.merge_page(page_1)
        page_A4.merge_page(page_2)
        writer.add_page(page_A4)
        print(str(int(i/int(len(arranged_pages)/2)*100))+'%')
    writer.write(output_path)
    remove(aux_path)
    print('Finished Booklet')

def overlay_pdf(pdf_path, output_path):
    #Auxiliar path to generate overlaped pdf file
    aux_path = '/home/cristoalvarado/aux_2.pdf'
    resize_pdf_A5(pdf_path, aux_path, 0)

    pdf_reader = PdfReader(aux_path)
    writer = PdfWriter()
    num_pages = len(pdf_reader.pages)
    
    A5_w = PaperSize.A5.width
    A5_h = PaperSize.A5.height
    
    page_A5 = PageObject.create_blank_page(width = A5_w, height = A5_h)

    for i in range(min(num_pages,40)):
        if i > 5:
            page = pdf_reader.pages[i]
            page_A5.merge_page(page)

    writer.add_page(page_A5)
    writer.write(output_path)
    remove(aux_path)
    print('Finished Overlay')

def showcase_pdf(pdf_path,output_path):
    #Output path is a png image and pdf_path is the original pdf
    pdf_reader = PdfReader(pdf_path)
    aux_path = os.getcwd()+'/aux/aux.pdf'

    #Obtain and generate a pdf with only the first page
    writer = PdfWriter()
    writer.add_page(page=pdf_reader.pages[0])
    writer.write(aux_path)
    
    #Convert pdf to png
    pdf_to_png(aux_path,output_path)

def pdf_to_png(pdf_path,output_path):
    images = convert_from_path(pdf_path)
    for img in images:
        img.save(output_path, 'PNG')
    remove(pdf_path)

def array_pages(num_pages,size_booklet):
    #Obtain number of booklets
    num_booklets = int(num_pages/(size_booklet*4)) + 1
    arranged_pages = []
    i = 0
    rearranged_booklets = 0
    #Rearrange as usual
    while num_booklets > 0:
        #If booklet is big enough
        if num_booklets != 1:
            for i in range(size_booklet):
                arranged_pages.append(rearranged_booklets + 1 + 2*i)
                arranged_pages.append(rearranged_booklets + 4*size_booklet - 2*i)
                arranged_pages.append(rearranged_booklets + 4*size_booklet - 1 - 2*i)
                arranged_pages.append(rearranged_booklets + 2 + 2*i)
            rearranged_booklets += 4*size_booklet
        #If booklet is too small
        else:
            #See where it got
            resting_number = num_pages - rearranged_booklets
            for i in range(int(resting_number/4)):
                arranged_pages.append(rearranged_booklets + 1 + 2*i)
                arranged_pages.append(rearranged_booklets + resting_number - 2*i)
                arranged_pages.append(rearranged_booklets + resting_number - 1 - 2*i)
                arranged_pages.append(rearranged_booklets + 2 + 2*i)
            rearranged_booklets += resting_number
        num_booklets -= 1
    print('Rearranged pages: '+str(rearranged_booklets))
    return arranged_pages