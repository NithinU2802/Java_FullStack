# JavaFullStack
    - Easy to develop and everything in one package.
    - "Spring MVC is a library within Spring framework
      that simplifies HTTP requests and response.
    - "MVC stands for model-view-controller.MVC allows
      the seperation of business, presentation, and 
      navigation logic.
    Note: Makes it super easy to setup website. Makes
          it super easy to seperate parts of project.

    • Layers and Mapping:
        - Controller Layer (http://localhost:8080)
        - Model Layer (Database)
        - View Layer (Web Page)
    
    • DispatcherServlet: (Working with http links)
        DispatcherServlet -> Handler Mapping -> 
        Controller -> View

# Connecting with DataBase
    - Update the application.properties so that the required 
    database will be connected with this project.
    - Ensure the usage of driver mapping with database server.
    - Now run the project also ensure that database is created
    on the db server.

# Creating an Repository
    - Normally an repository is used to load the data that are
    generated in the application.
    - Those data's are mapped with the entity which is create by
    an class.
    - Repository works close to the database. Also it can auto
    generate functions to find values on the database easier.

# DTO - Data Transfer Object
    - When we are working with an large project handling more 
    columns which can be break down into multiple table.
    - DTO make easier to access the required value available in 
    the database.

# Service
    - When we created an database and table these are need to 
    to be access by an package that regulate the data.
    - Here I use an interface to load list of object and that
    has been implemented by impl package.
    - In impl package it has ClubServiceImpl which is used to
    get the data and load it on the clobDto.

# Validation
        SpringBoot provide various annotation that makes our work
    Easy to validate the table before inserting values on it. Few
    notations are @NotNull @NotBlank @Email @Min @Max @Size @Pattern @Phone
    @Past.
        - Before Implement make sure these are implemented in DTO's not on
    the model directly.
        - Make sure that the controller has the method which used @Valid 
    keywork and BindingResult as parameters for validation.

    Eg:
        
    # Controller.java
        @PostMapping("/")
        public String checkPersonInfo(@Valid PersonForm personForm,BindingResult
        bindingResult){
            if(bindingResult.hasError())
                return "error.html";
            return "redirect:/results";
        }
    
    # form.html
        <!-- Include Followings -->
        <td>Name:</td>
        <td><input type="text" th:field="*{name}" /></td>
        <td th:if="${#fields.hasErrors('name')}" th:errors="*{name}" >Name</td>

# Users and Roles
    - Make an Many to Many Relationship with tables below.
    1. User - id, username, password
    2. Role - id, name
    Join Table - user_id and role_Id

# One-To-Many
    Here I had made an event model which make relationship with club
    that shows one to many relation.
    