SECTION II:

Q. With ERD you have already designed on question 1, what database are you using to implement? Why are you using that? What is the strong and weak point of it?

A. MySQL is a popular choice for implementing the backend of an e-commerce platform due to its reliability, scalability, and ease of use. Here are some of the strengths and weaknesses of MySQL:

**Strengths**:

Open source: MySQL is open source and free to use, which makes it a cost-effective solution for small to medium-sized e-commerce platforms.

Widely used: MySQL is one of the most popular RDBMS systems and has a large community of developers and users, which means that it has a vast pool of resources and support available.

Reliability: MySQL is known for its reliability and has been used by large-scale e-commerce platforms for years, which is a testament to its robustness.

Scalability: MySQL can scale horizontally and vertically, which makes it suitable for e-commerce platforms that expect to handle large volumes of data and traffic.

**Weaknesses**:

Limited scalability: While MySQL can scale well for small to medium-sized e-commerce platforms, it may not be ideal for larger platforms that need to handle massive volumes of data and traffic.

Complex queries: Some complex queries in MySQL can be slow, which may impact the performance of e-commerce platforms with a high volume of transactions.

---
SECTION III:

Q: What are the strong and weak points of your solution? How to improve that?

A:
**Strengths**:

- Scalable and Efficient
- Flexibility and Performance
- Security

**Weaknesses**:

- Store secret key

- Manage session

- Shorter Lifespan

**Improving**

- Using cache server to store active token and block token
- Using refresh token

Q: Build a solution for testing, ensure correct permission scalable from 100 APIs to 1000 APIs.

A.To ensure correct permission and scalability from 100 APIs to 1000 APIs, we can implement the following solutions:

- Role-based access control: Implementing a role-based access control (RBAC) system will ensure that only authorized users have access to the APIs. This will help prevent unauthorized access to sensitive data and functionality.
- API key authentication: Using API key authentication will allow us to authenticate and authorize access to the APIs. This will ensure that only authorized applications can access the APIs, preventing unauthorized access.
- Load balancing: Implementing load balancing will ensure that the API requests are distributed evenly across multiple servers. This will help prevent overload on a single server and ensure scalability as the number of API requests increases.
- Automated testing: Implementing automated testing will help ensure that the APIs are functioning as expected and prevent issues from reaching production. This will help ensure the quality and reliability of the APIs.
- API documentation: Providing comprehensive and up-to-date API documentation will help developers understand the APIs and how to use them correctly. This will help prevent issues caused by incorrect usage of the APIs.
- Monitoring and logging: Implementing monitoring and logging tools will help us track the performance and usage of the APIs. This will help us identify issues and optimize the APIs for better performance and scalability.

SECTION IV:
Good job, right now our application needs to synchronize products, pricing of the Agency by using third-party API

Q: What are the strong and weak points of your solution? How to improve that?

A.
**Strengths**:

- Always get the newest data

**Weaknesses**:

- during peak hours may slow down the query
- handle transaction more complexity

**Improving**
- Using cache server to help improve speed and performance
- Using CQRS Design Pattern to split read/write database
- Scale database in the peak time