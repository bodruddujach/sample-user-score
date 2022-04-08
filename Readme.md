# Sample User Score

Sample Spring Rest API for Managing Game-User and their Game Progress -

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. MySQL - 8.x.x

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/bodruddujach/sample-user-score.git
```

**2. Create Mysql database**
```bash
create database susDB
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
cd sample-user-score
mvn package
java -jar target/sample-user-score-0.0.1-SNAPSHOT.jar
```

You can also run the app without packaging it using -

```bash
mvn spring-boot:run
```

**5. Flyway location configuration**
There are two sql files named V1__Schema.sql and V2__Data.sql for flyway data migration  located under db/migration folder. -

It is recommeneded to not change the V1__Schema.sql file -

If you wish to load the database with more data, you can change/replace `db/migration/V2__Data.sql` with your data or you can modify `spring.flyway.locations` property from `src/main/resources/application.properties` file. Be careful about data confliction from multiple source files -

**6. REST End Points**
## Create User
`POST /users/`

### URL: http://localhost:7000/users/
### Mandatory HEADERS:
1. Content-Type: application/json

### Request Body
	{"id":16,"name":"Shopni","country":"Bhutan"}
	
### Expected Response
	Response Code: 201 CREATED

## GET User By Id
`GET /users/{id}`

### URL: http://localhost:7000/users/2
### Path-variable: 2
	
### Expected Response
	{
    		"id": 2,
    		"name": "Sakib",
    		"country": "Bangladesh"
	}


## Update User By Id
`PUT /users/{id}`

### URL: http://localhost:7000/users/2
### Mandatory HEADERS:
1. Content-Type: application/json

### Request Body
	{"id":2,"name":"Sakib","country":"Nepal"}
	
### Expected Response
	Response Code: 200 OK
	Response Body: {"id":2,"name":"Sakib","country":"Nepal"}

## GET User Progress By userId
`GET /user-progresses/{user-id}`

### URL: http://localhost:8080/user-progresses/2
### Path-variable: 2
	
### Expected Response
	{
		"id": 2,
		"level": 3,
		"score": 50.0,
		"user": {
			"id": 2,
			"name": "Sakib",
			"country": "Nepal"
		}
	}

## Save User Progress By userId
`POST /user-progresses/{user-id}`

### URL: http://localhost:8080/user-progresses/16
### Path-variable: 16
### Mandatory HEADERS:
1. Content-Type: application/json

### Request Body
	{
	    "level": 4,
	    "score": 67.45
	}	
### Expected Response
	Response Code: 201 CREATED
	Response Body:
	{
	    "id": 16,
	    "level": 4,
	    "score": 67.45,
	    "user": {
		"id": 16,
		"name": "Shopni",
		"country": "Bhutan"
	    }
	}


## Update User Progress By userId
`PUT /user-progresses/{user-id}`

### URL: http://localhost:8080/user-progresses/16
### Path-variable: 16
### Mandatory HEADERS:
1. Content-Type: application/json

### Request Body
	{
	    "level": 5,
	    "score": 71.45
	}	
### Expected Response
	Response Code: 201 CREATED
	Response Body:
	{
	    "id": 16,
	    "level": 5,
	    "score": 71.45,
	    "user": {
		"id": 16,
		"name": "Shopni",
		"country": "Bhutan"
	    }
	}
	

## GET List of 10 user progress based on top score value
`GET /leader-board/`

### URL: http://localhost:7000/leader-board/
	
### Expected Response
	Response Code: 200 OK
	Response Body:
	`[{"rank":1,"level":5,"name":"Kohli","score":95.0},{"rank":2,"level":2,"name":"Mushfiq","score":90.0},{"rank":3,"level":5,"name":"Shachin","score":88.5},{"rank":4,"level":3,"name":"Afridi","score":86.45},{"rank":5,"level":4,"name":"Liton","score":85.5},{"rank":6,"level":3,"name":"Nayem","score":85.0},{"rank":7,"level":5,"name":"Shopni","score":71.45},{"rank":8,"level":2,"name":"Warner","score":70.56},{"rank":9,"level":5,"name":"Pulok","score":68.0},{"rank":10,"level":2,"name":"Nabi","score":65.5}]`	
