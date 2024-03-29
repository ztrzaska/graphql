# A reference implementation of GraphQL for Spring boot

### Getting Started

The following application illustrate simple functionalities with graphQL API. It has queries and mutations. Default queries are written to playground.

At dedicated branches there are integration with two different graphql libraries, graphql-java-kickstart and spring for graphql.

### Playground
```
http://localhost:9001/playground
```

### Voyager
```
http://localhost:9001/voyager
```

### Curl
```
curl  --url http://localhost:9001/graphql -H 'Accept:application/json' --data-binary "{\"query\": \"query { books { id name }}\", \"variables\" : {}}"
```

### Uploading file to server

```
curl -v -F operations="{\"query\": \"mutation { uploadFile }\", \"variables\" : {}}" -F upload=@D:/a.txt http://localhost:9001/graphql
```

## Documentation of the libraries used
* [GraphQL documentation](https://graphql.org/)
* [GraphQL Extended scalars documentation](https://github.com/graphql-java/graphql-java-extended-scalars)
* [Spring for GraphQL documentation](https://spring.io/projects/spring-graphql)
* [Graphql-java-kickstart github](https://github.com/graphql-java-kickstart)
* [Spring boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Hibernate validator](https://hibernate.org/validator/)

