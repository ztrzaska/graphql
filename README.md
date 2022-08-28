# GraphQL API

### Guides

The following application illustrate simple functionalities with graphQL API. It has queries and mutations. Default queries are written to playground. 


### Playground
```
http://localhost:9001/playground
```

### Voyager
```
http://localhost:9001/voyager
```

### Uploading file to server

```
curl -v -F operations="{\"query\": \"mutation { uploadFile }\", \"variables\" : {}}" -F upload=@D:/a.diff http://localhost:9001/graphql
```

## Documentation of the libraries used
* [GraphQL documentation](https://graphql.org/)
* [GraphQL Extended scalars documentation](https://github.com/graphql-java/graphql-java-extended-scalars)
* [Spring boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Hibernate validator](https://hibernate.org/validator/)

