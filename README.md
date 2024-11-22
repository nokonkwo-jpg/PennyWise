# PennyWise

This is PennyWise! Built with **Spring Boot**, **Thymeleaf**, and **Bootstrap**, it helps users manage their bank accounts. It supports creating accounts, viewing transactions, and performing essential operations like deposits, withdrawals, and account deletion—all in a user-friendly interface.

---

## Why I Built This Project

I’ve always found it frustrating how difficult it is to get a clear view of all my finances in one place. My banking apps separate my checking, savings, credit cards, and investments, which makes it hard to figure out your actual financial situation at a glance. On top of that, credit card purchases often wouldn’t show up in the checking account balance till I paid it off, which can be confusing when I'm trying to budget or keep track of my spending.

That’s what inspired me to build this project—a dashboard where you can see everything together in one spot. I wanted something that not only combines all my accounts but also factors in credit card purchases to show my real balance. It’s a simple idea, but it makes a huge difference in understanding where my money is going.

---

## What’s Next?

This is just the start. The next step is to connect the app to my actual bank data using **Plaid's API**. The goal is to pull in information from all my financial institutions and organize it into a CSV file with graphs that show my spending trends and other insights. It’s all about making the data easy to use and actionable.

For me, this project is as much about solving a personal problem as it is about learning new skills and exploring what’s possible. There’s a lot more I want to add, and I’m excited to see where it goes next. 🚀

---

## Features

1. **View All Accounts**:  
   Displays a list of all accounts with details such as:
    - Account ID
    - Holder Name
    - Balance
2. **View Transactions**:
    
    Displays a list of all transactions from a given account by:
    - Date
    - Transaction Type
    - Amount Transacted

3. **Add New Account**:  
   Create new accounts with:
    - Account holder's name
    - Initial balance

4. **Deposit**:  
   Deposit funds into a specific account.

5. **Withdraw**:  
   Withdraw funds from a specific account.

6. **Delete Account**:  
   Permanently delete an account after confirmation.

---

## Technologies Used

- **Backend**: Spring Boot
    - Thymeleaf for server-side templating
    - Spring MVC for routing
    - Spring Data JPA for data persistence
- **Frontend**: Bootstrap for responsive UI
- **Database**: PostgreSQL

---

## Quick Start

## 1. Clone the repository:
   ```bash
   git clone https://github.com/nokonkwo-jpg/PennyWise.git
   cd bankapp
   ```

## 2. Open the Project
- Launch **IntelliJ IDEA**.
- Open your Spring Boot project via **File > Open**.

## 3. Ensure Dependencies are Loaded
- Click the **Refresh** button in the **Maven** tool window (on the right).


## 4. Run Main Class
1. Navigate to `src/main/java/BankappApplication` .
2. Right-click and select **Run 'BankappApplication'**.

## 5. Access the Application
- Visit `http://localhost:8080` in your browser.

# API Endpoints

## Accounts

| Method | Endpoint                       | Description               |
|--------|--------------------------------|---------------------------|
| GET    | `/`                    | View all accounts         |
| POST   | `/accounts/add`                | Add a new account         |
| POST   | `/accounts/delete/{accountId}` | Delete an account by ID   |
| POST   | `/{id}/deposit`                | Deposit into an account   |
| POST   | `/{id}/withdraw`               | Withdraw from an account  |
| GET    | `/{id}/transactions`           | View transactions for an account |

