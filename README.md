#Ordering tasking

### Total Time: 209 min (about 3.5 hours)


* ###/products

1. return 201 when POST product  
 estimate: 3 min  
 t: 2 min


2. create product with parameters and find product by product id  
 e: 20 min  
 r: 17 min
  
  
3. return 201 when POST product with parameters  
 e: 5 min  
 r: 5 min
  
  
4. return 400 when POST product with invalid parameters  
 e: 8 min  
 4: 11 min
  
  
5. return 200 when GET products  
 e: 3 min  
 r: 2 min
  

6. find all products  
 e: 8 min  
 r: 3 min
  
  
7. return a list of product json when GET products  
 e: 5 min  
 r: 7 min
  

* ###/products/{productId}

1. return product json when GET product by product id  
 e: 10 min  
 r: 4 min
  
    
  
2. return 404 when GET product by product id fails  
 e: 3 min  
 r: 2 min
  
  
  
 

* ###/users

1. return 201 when POST user  
 e: 5 min  
 r: 2 min
  
  
 
2. create user with parameters and find user by user id  
 e: 15 min  
 r: 11 min
  
  
  
3. return 201 when POST user with parameters  
 e: 5 min  
 r: 4 min
  
  
  return url
  
  r: 6 min
  
  
4. return 400 when POST product with invalid parameters  
 e: 8 min  
 r: 4 min
    

    

  
  
 

* ###/users/{userId}

1. return user json when GET user by user id  
e: 10 min  
r: 6 min
 
2. return 404 when GET by user id not found  
 e: 5 min  
 r: 2 min
  
  
* ###/users/{userId}/orders

1. return 201 when POST order  
 e: 3 min  
 r: 4 min
  

2. create order without orderItems and find by user id and order id  
 e: 20 min  
 r: 18 min  
    
   
3. create order with orderItems and find by user id and order id  
 e: 15 min  
 r: 30 min
    
    
4. return 201 when POST order with parameters  
 e: 8 min  
 r: 6 min
  
    
5. return 200 when GET orders  
 e: 3 min  
 r: 2 min
  
  
6. find orders  
 e: 5 min  
 r: 3 min
  
 
7. return a list of order json when GET orders  
 e: 10 min  
 r: 9 min
  
  
    
 

* ###/users/{userId}/orders/{orderId}

1. return order json when GET order by user id and order id  
 e: 10 min  
 r: 7 min
  
  

2. return 404 when GET order by user id and order id fails  
 e: 3 min  
 r: 2 min
  
   
* ###/users/{userId}/orders/{orderId}/payment

1. return 201 when POST payment  
 e: 3 min  
 r: 3 min
  
  
  
 
2. create payment with parameters and find payment by order id  
 e: 15 min  
 r: 15 min
  
  

3. return 201 when POST with parameters  
 e: 10 min  
 r: 6 min
  
  return 400 when post with invalid parameters
  r: 3 min

4. return payment json when GET payment by order id   
 e: 5 min  
 r: 10 min
  
  
  
 
5. return 404 when GET payment by order id fails  
 e: 3 min  
 r: 3 min
  
  
  
