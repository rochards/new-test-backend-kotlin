
# Product Catalog Management API

> :building_construction: Work in progress...

Hi there! This repository is my implementation of the challenge described below the **Original challenge and its requirements** section.

Before reading any further, I would like to highlight the key changes I've made compared to the original challenge:
- My implementation will be done in Kotlin and Spring Boot;
- AWS services will be emulated using [LocalStack](https://docs.localstack.cloud/getting-started/) to avoid the need for an actual AWS account.

### How to run the project

Requirements:
- Docker Engine with docker compose;
- Execute `chmod +x build-and-run-script.sh` go give execution permission to the file;
- Run `./build-and-run-script.sh`

To view the Mongo collection:
- open http://0.0.0.0:8081/ on browser and provide username -> **admin**, password: **pass**;

To access grafana:
- open http://localhost:3000/ on browser and provide username -> **admin**, password: **admin**;

## Original challenge and its requirements

- Original title: **Backend Analyst Candidate Test**

### The Challenge

Your task is to develop an API using Node.js for a product catalog management system in a marketplace application. You should analyze and convert the following user stories into routes for the application:

### User Stories:

- As a user, I want to register a product with its owner, so that I can access its data in the future (title, description, price, category, owner ID).
- As a user, I want to register a category with its owner, so that I can access its data in the future (title, description, owner ID).
- As a user, I want to associate a product with a category.
- As a user, I want to update the data of a product or category.
- As a user, I want to delete a product or category from my catalog.
- A product can only be associated with one category at a time.
- Assume that products and categories belong only to one owner.

- Keep in mind that this is an online product catalog, which means there will be multiple requests for editing items/categories per second, as well as accessing the catalog search endpoint.
- Consider the product catalog as a JSON compilation of all available categories and items owned by a user. This way, the catalog search endpoint does not need to fetch information from the database.
- Whenever there is a change in the product catalog, publish this change to the "catalog-emit" topic in the AWS SQS service.
- Implement a consumer that listens to catalog changes for a specific owner.
- When the consumer receives a message, search the database for that owner's catalog, generate the catalog JSON, and publish it to an AWS S3 service bucket.

### You need to develop this test using the following technologies

- MongoDB for the database.
- AWS SQS for the catalog change notifications.
- AWS S3 for storing the catalog JSON.
- Node.js for the backend.
- Express.js as the web framework.

### Diagram representing the final structure of the project:</strong> <br><br>
![image](https://github.com/githubanotaai/new-test-backend-nodejs/assets/52219768/504ba448-f128-41db-ae86-18dc19c0dc9d)


### Instructions

**To begin the test, fork this repository, create a branch with your full name, and send us the link to your completed test (link to your repository). If you only clone the repository, you won't be able to push changes, making the pull request more complicated.**
- Use your own AWS account to set up the required services.
- Update the README file with instructions on how to run your application.
- Paste the branch name into the GUPY system and indicate the completion of the test.
- Feel free to provide us with feedback regarding the test.

### Our Evaluation Criteria
We will assess the following aspects of your solution:

- Knowledge of JavaScript, Node.js, and Express.js.
- Proper structure of the application layers.
- Handling of outgoing calls.
- Effective use of environment variables.
- Implementation of unit tests.
- Logging mechanisms.
- Error handling strategies.
- Documentation quality.
- Code organization, module separation, readability, and comments.
- Commit history.
