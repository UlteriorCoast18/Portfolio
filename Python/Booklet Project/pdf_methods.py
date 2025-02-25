from PyPDF2 import PdfReader, PdfWriter, Transformation, PageObject, PaperSize
from PyPDF2.generic import RectangleObject

def resize_pdf(pdf_path, output_path, size_booklet):
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
    writer.write(output_path)


    #Obtenemos el número de páginas
    #num_pages = 

    #Reescalamos todas las páginas del pdf
    """
    for page in pdf_reader.pages:
        page.scale_by(2)
        writer.add_page(page)
    """
    #Operamos con el número de páginas para saber cuantos cuadernillos hacer    
    
    #Número total de cuadernillos
    #num_booklets = int(num_pages/(size_booklet*4)) + 1
    #Páginas restantes en el último cuadernillo
    #num_rest = num_pages - int(num_pages/(size_booklet*4))*(size_booklet*4)
    
    #array_pages = array_pages(num_booklets,num_rest)

    print('finished')

    return 0;

def array_pages(num_booklets,num_rest):
    return 0;