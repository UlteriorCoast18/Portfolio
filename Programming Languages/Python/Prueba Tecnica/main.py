import psycopg2, csv, os

#database connection

connection = psycopg2.connect(
    database="prueba_tecnica",
    user="postgres",
    password="postgres",
    host="127.0.0.1",
    port='5432'
)

#CSV reading

def insert_data_database_csv():
    cont = 0
    input_path_csv = os.getcwd()+'/data_prueba_tecnica 1.csv'
    with open(input_path_csv, mode = 'r') as file:
        reader = csv.reader(file)
        for row in reader:
            if row != [] and cont == 3:
                if not is_company_name_in_db(row[1]): insert_company_name(row[1],row[2])
                #print(row)
                #print(row[4])
                #if not is_status_in_db(row[4]): insert_status(row[4])
                # insert_row(row)
            cont += 1           
    #print(cont)

#Methods to check data and insert it into database

def is_company_name_in_db(company_name):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = """SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'"""
        cursor.execute(postgreSQL_select_Query, (company_name,))
        name = cursor.fetchall()
        print(name)
        if name == []: return False
        else: return True
    except (Exception, psycopg2.Error) as error:
        print("Error while selecting company_name", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def is_status_in_db(status):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "SELECT status FROM Status_Table WHERE status=%s;"
        cursor.execute(postgreSQL_select_Query, (status,))
        status = cursor.fetchall()
        if status == []: return False
        else: return True
    except (Exception, psycopg2.Error) as error:
        print("Error while while selecting status", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def insert_company_name(company_id, company_name):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "INSERT INTO company (company_id, company_name) VALUES (%s, %s);"
        cursor.execute(postgreSQL_select_Query, (company_id, company_name,))
    except (Exception, psycopg2.Error) as error:
        print("Error while inserting company_name", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def insert_status(status):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "INSERT INTO status_table (status) VALUES (%s);"
        cursor.execute(postgreSQL_select_Query, (status,))
    except (Exception, psycopg2.Error) as error:
        print("Error while inserting status", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def get_id_company(company_name):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "SELECT company_id FROM company WHERE company_name=%s;"
        cursor.execute(postgreSQL_select_Query, (company_name,))
        company = cursor.fetchall()
        return company[0][0]
    except (Exception, psycopg2.Error) as error:
        print("Error while getting company_id", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def get_status_id(status):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "SELECT status_id FROM status_table WHERE status=%s;"
        cursor.execute(postgreSQL_select_Query, (status,))
        status = cursor.fetchall()
        print(status)
        return status
    except (Exception, psycopg2.Error) as error:
        print("Error while while getting status_id", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def insert_row(row):
    try:
        cursor = connection.cursor()
        postgreSQL_select_Query = "INSERT INTO transactions (id, company_id, status_id, amount, created_at, updated_at) VALUES (%s, %s, %s, %s, %s,%s);"
        cursor.execute(postgreSQL_select_Query, (row[0], row[2], get_status_id(row[4])[0][0], row[3], row[5], row[6], ))
        print("asdf")
    except (Exception, psycopg2.Error) as error:
        print("Error while inserting row", error)
    finally:
        if connection:
            cursor.close()
            connection.rollback()

def main():
    insert_data_database_csv()

if __name__ == '__main__':
    main()