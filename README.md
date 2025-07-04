# Fawry E‑Commerce Assessment

**Assessment task for the Fawry Full‑Stack Development Internship.**

---

## Features

- **Product abstraction** with pluggable behaviors:
  - **Expirable** (e.g., cheese, biscuits)  
  - **Shippable** (e.g., TV, cheese)  
  - **Non‑shippable** (e.g., mobile scratch cards)  
- **Inventory tracking**: name, price, quantity  
- **Customer cart management**:
  - Add/remove items  
  - Compute cart total  
- **Checkout workflow**:
  - Calculates shipping cost based on weight  
  - Prints an itemized receipt  

---

## Architecture & Design

1. **Model**  
   - **Abstractions** (`com.implementation.model.abstractions`)  
     - `Product` abstract class  
     - `Expirable` interface  
     - `Shippable` interface  
   - **Concrete** (`com.implementation.model.concrete`)  
     - `ShippableProduct`  
     - `ExpirableAndShippableProduct`  
     - `ExpirableProduct`
     - (If there is new type of product it will fit easily in the implementation due to OCP)

2. **User‑Related** (`com.implementation.model.concrete.UserRelated`)  
   - `Cart`  
   - `Customer`  

3. **Services** (`com.implementation.services`)  
   - `CartService` — cart operations (add/remove/list)  
   - `CheckoutService` — final validation & total calculation  
   - `ReceiptPrinter` — prints or logs the receipt  
