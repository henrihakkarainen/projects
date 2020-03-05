# Quite simple API implementation

During the Fullstack developer education we created a weather backend which reads data sent from a weather measurement machine to the database and the user can view that data by sending GET-requests to correct URLs. Posting of own data is also possible for API testing purposes. Javascript-file can be found under src-folder.

Some basic Mocha + Chai tests were also implemented for practice purposes and those can be found under test-folder.

During the API implementation we were using Docker for setting up the environment and to deploy the application to TAMK servers via Git pipeline. Some of the CI/CD pipeline .yml-files are not found from this repository.

Techniques used:

- Node.js
- PostgreSQL
- Koa
- ESlint
- Docker
- Mocha and Chai (testing)