## Sring MVC Film C.R.U.D.

### Overview
Created as an extension of the Film Query Project, this MVC Film Site is designed to model a dynamic working database and query website wherein a user can view or add information, as well as update or delete that information from the database.

### Spring MVC Framework and DAO Design Pattern
As with any dynamic web page, our program had to handle many tasks as a result of the request/response cycle. The Spring framework made it very efficient to implement our MVC and DAO design patterns in order to create a separation of concerns for handling those various responsibilities.

#### Model
For our program, we implemented the DAO pattern to handle the bulk of the business logic. We created a film data object that was used for object relational mapping between the film table in our MySQL database and the business logic of our program. We also created a FilmDAO interface that laid out all the various methods that were needed to supply our controller with the data it needs to provide a response to the user. Finally, we used Java Database Connectivity in our implementation class. JDBC is a powerful API that enabled us to connect to the database and run SQL commands from our application code. This is what allowed us to bridge the gap from user requests for data into an SQL command that actually retrieves or manipulates that information in the data base. Utilizing this design pattern is very powerful. Because we set up our DAO interface we could easily change where we get our data from by simply changing the implementation class. For example, if our MySQL database wasn't up and running yet, we could have created a mock implementation class with hardcoded data representing a film database and constructed our business logic from there. Or we could have a file implementation class that gets data representing a film database from an external file. All of these implementations would work, and could be changed very easily because of our use of the DAO pattern.

#### View
For the view aspect of our MVC design, we created several .jsp and .html files. These files are what make up our website's graphical interface. We used standard HTML along with the Java Server Tag Libraries and expression language to construct a clean looking webpage containing the proper data for display to the client as a response to their requests.

The user is first presented with a landing page index.html which provides them with options to list all the films in the database, add a film to the database, find a film by its ID, or find a film by keyword. When the client makes a request from this page, the request get's mapped by our controller, the model does its thing and returns data to present back to the client.

#### Controller
The controller is where Spring was the most helpful. We created a FilmController class and designated it as a controller using the @Controller annotation. This class essentially acted as a middleman between the client requests and the response from the server.  Instead of having many many servlets for mapping each of these requests, we were able to do it all in this one controller class. Using the @Autowired annotation, Spring easily finds the bean we defined in our configuration file (Film-servlet.xml) to construct our implementation class. We can then use a series of @RequestMapping annotations to direct all the client requests and data to the correct methods in our implementation class. From there, the business logic gets handled and we can return the resulting data in the form of a web page (view) back to the client by specifying which .jsp file to display.

For a couple of the request mappings, we also utilized Spring command objects. These were extremely useful for constructing a full film object in our model without having to pass in each and every parameter to the controller.

### SQL - Database Manipulation Language (DML)
Another key highlight of this project is the use of SQL data manipulation language. This particular website allows the user to not only read from the database but also, insert, update and/or delete entries from the database. We accomplished this in our model by using JDBC to connect to the database and run SQL commands from our application code. When the user adds a film to the database, we used INSERT SQL statements. When they updated film information, we used UPDATE SQL statements. And finally, when the client deletes a film from the database, we used DELETE SQL statements. All of these statements were executed using data the client sent in through our web pages forms in order to supply the statement with the data needed to insert, update or delete the correct film.


### Other Technologies Used
This dynamic web project combines the multiple implementation capabilities of a single Interface with the ability to manipulate information in an operational database with the addition of Bootstrap front end framework. This project also displays our ability to navigate a database and properly create a SQL command that brings back accurate information in response to the request.

* PRG (Post redirect Get): In order to handle some of the client requests without messing up the database, we utilized the PRG pattern. For example, when the user adds a film to the database, it is handled as a post request initially to update the database. But we only allow the data to be used one time before redirecting the request to another mapping that returns a view to the user. Now when they refresh the page, they cannot continuously add that film to the database.

* GitHub Version Control: GitHub was an excellent tool allowing Kim and I to work together on this project and merge the changes we each made by simply committing, pulling and pushing our changes to our shared repository.

* Bootstrap: Although we didn't really dive deep into the power of bootstrap, our project does have very simple bootstrap styling elements.

* Gradle: We utilized Gradle as our build automation tool for this project. This was essential for managing our projects dependencies such as the Spring framework, java servlets, JDBC, and JSTL.

* View Resolver: We defined a bean in our Spring configuration file that appends the file path prefix and suffix of the jsp files we created to display our web pages to the user. This was a simple addition that made our code in the controller class easier to write.

### Lessons Learned
This project was not only a lesson in dynamic user interfaces and web pages, but also time management, team coordination, and communication. It provided the opportunity to practice practical development operations wherein a repository is shared and updates are pulled and checked before pushing.
