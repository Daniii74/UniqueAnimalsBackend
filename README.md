# UniqueAnimalsBackend
# f25-jpa-crud-api
Simple CRUD API for Unique Animal Objects with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/Daniii74/UniqueAnimalsBackend.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/Daniii74/UniqueAnimalsBackend/blob/main/demo/pom.xml) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/Daniii74/UniqueAnimalsBackend/blob/main/demo/src/main/resources/application.properties) This file has the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.
## Notes
### Java - [Spring ORM with JPA and Hibernate](https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac)
- We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.
- JPA (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks to make concrete implementations.
- Hibernate: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.
Spring ORM allows seamless integration of Hibernate and JPA, making database interactions more manageable and reducing boilerplate code.
### Unique AnimalX Java classes have different purposes: Separation of concerns!
- [Entity](https://github.com/Daniii74/UniqueAnimalsBackend/blob/28744955629cbe64d81f5d92220ccb85f213039d/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimal.java#L13)
  - The Unique Animal class is annotated as an `@Entity `. This is used to map class attributes to database tables and SQL types.
  - We also annotated with `@Table` to give Hibernate directions to use this specific table name. This is optional but it helps with naming conventions.
  - Any Entity must have at least one attribute that is annotated as an `@Id`. In our case it's conveniently the `Id` attribute.
    - We are also using an autogeneration strategy for the ID. This way we are not manually assigning IDs to our Unique Animals. This is optional.
       - For this reason, we also added a constructor to make a Unique Animal without an ID.
  - An Entity must have a no-argument constructor.
- [Repository](https://github.com/Daniii74/UniqueAnimalsBackend/blob/main/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalRepository.java)
  - We are using an extension of the JPA Repository that comes with prebuilt database operations such as select all, select by id, select by any other reference, insert, delete, etc.
  - Annotate it as a `@Repository`.
  - We parametrize this using our object and its ID type.
    - `public interface Unique AnimalRepository extends JpaRepository<Unique Animal, Long>` => We want to apply the JPA repository operations on the `Unique Animal` type. The `Unique Animal` has an ID of type `long`.
  - If we need special database queries that are not the standard ones mentioned above, we can create [a method with a special purpose query](https://github.com/Daniii74/UniqueAnimalsBackend/blob/28744955629cbe64d81f5d92220ccb85f213039d/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalRepository.java#L12) as shown. This is an interface so no implementation body.
- [Service](https://github.com/Daniii74/UniqueAnimalsBackend/blob/main/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalService.java)
  - Annotated as a `@Service`.
  - It is the go-between from controller to database. In here we define what functions we need from the repository. A lot of the functions are default functions that our repository inherits from JPA (save, delete, findAll, findByX), some of them are custom made (getHonorsUnique Animals, getUnique AnimalsByName).
  - It asks the repository to perform SQL queries.
  - The Repository class is [`@Autowired`](https://github.com/Daniii74/UniqueAnimalsBackend/blob/28744955629cbe64d81f5d92220ccb85f213039d/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalService.java#L10). This is for managing the dependency to the repository. Do not use a constructor to make a Repository object, you will get errors.
- [Rest Controller](https://github.com/Daniii74/UniqueAnimalsBackend/blob/28744955629cbe64d81f5d92220ccb85f213039d/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalController.java#L14)
  - Annotated as a `@RestController`.
  - It asks the Service class to perform data access functions.
  - The Service class is [`@Autowired`](https://github.com/Daniii74/UniqueAnimalsBackend/blob/28744955629cbe64d81f5d92220ccb85f213039d/demo/src/main/java/com/example/demo/UniqueAnimal/uniqueanimalController.java#L16) here as well :)

## API Endpoints


1. ### [`/Uniqueanimals`](http://localhost:8080/uniqueanimals) (GET)
Gets a list of all Unique Animals in the database.

#### Response - A JSON array of Unique Animal objects.

 ```
[
  {
    "name": "Narwhal",
    "description": "A medium-sized toothed whale known for the long, spiral tusk that protrudes from the males' heads.",
    "summary": "Arctic whale with a spiral tusk.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 50.0,
    "region": "Arctic Ocean",
    "id": 2
  },
  {
    "name": "Fennec Fox",
    "description": "A small nocturnal fox with enormous ears, adapted for life in the Sahara Desert.",
    "summary": "Tiny desert fox with large ears.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "North Africa",
    "id": 6
  },
  {
    "name": "Quokka",
    "description": "A small marsupial known for its friendly appearance and frequent 'smile.'",
    "summary": "Smiling marsupial from Australia.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "Australia",
    "id": 8
  },
  {
    "name": "Okapi",
    "description": "A mammal with zebra-like legs and a giraffe-like body, native to the rainforests of the Congo.",
    "summary": "Rainforest mammal with zebra stripes.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 30.0,
    "region": "Mexico",
    "id": 9
  }
]
```

2. ### [`uniqueanimal/{id}`](http://localhost:8080/uniqueanimal/9) (GET)
Gets an individual Unique Animal in the system. Each Unique Animal is identified by a numeric `Id`

#### Parameters
- Path Variable: `Id` &lt;Long &gt; - REQUIRED

#### Response - A single Unique Animal

```
  {
  "name": "Okapi",
  "description": "A mammal with zebra-like legs and a giraffe-like body, native to the rainforests of the Congo.",
  "summary": "Rainforest mammal with zebra stripes.",
  "dateAdded": "2025-10-06",
  "lifeSpan": 30.0,
  "region": "Democratic Republic of the Congo",
  "id": 9
}
```

3. ### [`/uniqueanimals/search`](http://localhost:8080/uniqueanimals/search?name=Quokka) (GET)
Gets a list of Unique Animals with a name that contains the given string.

#### Parameters
- query parameter: `search` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Unique Animal objects.

```
[
  {
    "name": "Quokka",
    "description": "A small marsupial known for its friendly appearance and frequent 'smile.'",
    "summary": "Smiling marsupial from Australia.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "Australia",
    "id": 8
  }
]
```

4. ### [`/region/{region}`](http://localhost:8080/uniqueanimals/region/africa) (GET)
Gets a list of Unique Animals for a named region.

#### Parameters
- path variable: `region` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Unique Animal objects.

```
[
    {
    "name": "Fennec Fox",
    "description": "A small nocturnal fox with enormous ears, adapted for life in the Sahara Desert.",
    "summary": "Tiny desert fox with large ears.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "North Africa",
    "id": 6
  }
]
```

5. ### [`/uniqueanimals`](http://localhost:8080/uniqueanimals) (POST)
Create  a new Unique Animal entry

#### Request Body
A Unique Animal object. Note the object does not include an ID as this is autogenerated.
```
  {
    "name": "Fennec Fox",
    "description": "A small nocturnal fox with enormous ears, adapted for life in the Sahara Desert.",
    "summary": "Tiny desert fox with large ears.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "North Africa",
  }
```
#### Response - The newly created Unique Animal.

```
    {
    "name": "Fennec Fox",
    "description": "A small nocturnal fox with enormous ears, adapted for life in the Sahara Desert.",
    "summary": "Tiny desert fox with large ears.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "North Africa",
    "id": 6
  }
```

6. ### [`uniqueanimal/{id}`](http://localhost:8080/uniqueanimal/9) (PUT)
Update an existing Unique Animal.

#### Parameters
- Path Variable: `Id` &lt;integer&gt; - REQUIRED

#### Request Body
A Unique Animal object with the updates.
```
{
  "name": "Okapi",
  "description": "A mammal with zebra-like legs and a giraffe-like body, native to the rainforests of the Congo.",
  "summary": "Rainforest mammal with zebra stripes.",
  "dateAdded": "2025-10-06",
  "lifeSpan": 30.0,
  "region": "Mexico",
}
```
#### Response - the updated Unique Animal object.
```
{
  "name": "Okapi",
  "description": "A mammal with zebra-like legs and a giraffe-like body, native to the rainforests of the Congo.",
  "summary": "Rainforest mammal with zebra stripes.",
  "dateAdded": "2025-10-06",
  "lifeSpan": 30.0,
  "region": "Mexico",
  "id": 9
}
```

7. ### [`uniqueanimal/{id}`](http://localhost:8080/uniqueanimals/1) (DELETE)
Delete an existing Unique Animal.

#### Parameters
- Path Variable: `Id` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Unique Animals.
```
[
  {
    "name": "Narwhal",
    "description": "A medium-sized toothed whale known for the long, spiral tusk that protrudes from the males' heads.",
    "summary": "Arctic whale with a spiral tusk.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 50.0,
    "region": "Arctic Ocean",
    "id": 2
  },
  {
    "name": "Fennec Fox",
    "description": "A small nocturnal fox with enormous ears, adapted for life in the Sahara Desert.",
    "summary": "Tiny desert fox with large ears.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "North Africa",
    "id": 6
  },
  {
    "name": "Quokka",
    "description": "A small marsupial known for its friendly appearance and frequent 'smile.'",
    "summary": "Smiling marsupial from Australia.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 10.0,
    "region": "Australia",
    "id": 8
  },
  {
    "name": "Okapi",
    "description": "A mammal with zebra-like legs and a giraffe-like body, native to the rainforests of the Congo.",
    "summary": "Rainforest mammal with zebra stripes.",
    "dateAdded": "2025-10-06",
    "lifeSpan": 30.0,
    "region": "Mexico",
    "id": 9
  }
]
```
#### Video Link
- [Video Link](https://uncg-my.sharepoint.com/:v:/g/personal/d_asif_uncg_edu/EZqFp04ii9RPnOlXZdRFfCkBKb4-uLs_dkQexM-rpmshaQ?e=Ezrv0l)