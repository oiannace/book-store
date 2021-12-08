# inventory-manager-api
REST api for an inventory management system using Java, Spring Boot and MySQL

This api completes GET, POST, and DELETE requests which manage the inventory of an online store in a MySQL database. 

**NOTE: In order to connect to the database you need a MySQL account, and in the file application.properties changes need to be made to the following properties to represent your username and password.

spring.datasource.username=root  
spring.datasource.password=pass

**GET Request**

The client can search an inventory item by name, and if it exists in the database it will return an object of the item which can then be used to complete further operations. A GET request to search for an item by name in curl would be as follows:

curl -X GET "http://localhost:8081/api/v1/Book/search?bname=BOOKNAME"

Where BOOKNAME is replaced with the specific name to be searched.


**POST Request**

The client can add an item to the inventory by making a post request with the required details of the item. In this example case, a books ID, name, and price are required as parameters to create the database entry. A POST request to add an item to the database in curl would be as follows:

curl --data "num=ID&bname=BOOKNAME&price=PRICE" http://localhost:8081/api/v1/Book

Where ID, BOOKNAME, and PRICE are replaced by the specific information desired.


**DELETE Request**

The client can delete an item from the inventory by making a DELETE request with the ID of the desired item. A DELETE request to remove a book from the databse in curl would be as follows:

curl -X DELETE http://localhost:8081/api/v1/Book/ID

Where ID is the specific ID of the item to be deleted.

