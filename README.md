
# Faire Backend Exercise

### Details:

Using the Faire API*1, you will write a program that accepts an API key as a single command line parameter, which should be sent with all requests in the X-FAIRE-ACCESS-TOKEN header, and does the following:

* Consumes all products for a given brand*2, recording the inventory levels for each product option
* Consumes all orders, accepting the order if there is inventory to fulfill the order, otherwise it marks the items that don’t have enough inventory as backordered
* Update the inventory levels of product options as each order is moved to processing
* After all orders have been processed, the program should print the following metrics, plus 2 of your choosing, and then exit - your creativity is welcome!

* The best selling product option
* The largest order by dollar amount
* The state with the most orders

For testing, you can use the API key: HQLA9307HSLQYTC24PO2G0LITTIOHS2MJC8120PVZ83HJK4KACRZJL91QB7K01NWS2TUCFXGCHQ8HVED8WNZG0KS6XRNBFRNGY71

* 1 - The base URL to use is https://www.faire-stage.com

* 2 - We recommend using Tea Drops, brand token = b_d2481b88


### Solution

##### Project Name: Faire Order Processing Batch (F.O.P)

* ** Description **: Batch process to be responsible for processing the orders extracted from Faire API.
* ** Technology stack ** : Java 1.8, Spring batch, Spring boot, H2 database, JPA, RestTemplate

* ** Project Author  **: Alexandre Barbosa de Sousa (abdesousa@gmail.com)

