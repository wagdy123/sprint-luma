# 🛒 E-commerce Website Selenium Automation

This project performs automated testing for critical functionalities of an e-commerce website using **Selenium WebDriver** with **Java**, **TestNG**, and **Page Object Model (POM)**.  
Key test areas include product search, adding items to cart, and handling invalid inputs.

---

## 🧰 Technologies Used
- Java 23 (Preview Features Enabled)
- Selenium WebDriver 4.27.0
- TestNG 7.10.2
- Apache POI 5.2.3
- Maven
- Page Object Model (POM)

---

## ✅ Automated Test Cases
1. **Valid Product Search**
2. **Add Product to Cart**
3. **Valid Complete Purchasing**

---

## 🔧 Setup Instructions

### ✅ Prerequisites:
- Java JDK 23
- Maven
- Chrome browser
- IntelliJ IDEA

---

### 📥 1. Clone the Repository:
```bash
git clone https://github.com/wagdy123/sprint-luma
```

---

### 📂 2. Navigate to Project Directory:
```bash
cd selenium
```

---

### 📦 3. Install Dependencies and Build the Project:
```bash
mvn clean install
```

---

## ▶️ Execution Instructions

---

### 🧪 Run Tests via `testng.xml`:
1. Open the `testng.xml` file in your IDE.
2. Right-click on it and select `Run 'testng.xml'`.

---

### 📊 View Test Report:
After test execution, open:
```
test-output/index.html
```

you can also find it on google drive here : [https://drive.google.com/drive/folders/1polZr_jM5GbwEtVjbYEA6oK7IOSDUWcu?usp=drive_link]


---

### 📊 View Test Cases and Bug Report:

google drive here : [https://drive.google.com/drive/folders/1polZr_jM5GbwEtVjbYEA6oK7IOSDUWcu?usp=drive_link]

Or open:
```
test cases - bug reports/assignment.xlsx
```


---


## ⚠️ Notes:
- If you're using Java 23, ensure **preview features** are enabled:
  - IntelliJ IDEA:  
    `File > Project Structure > Language Level > 23 (Preview)`
  - Or add compiler argument: `--enable-preview`
