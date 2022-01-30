# jpa-parakeet
Idea of this repository is to go over simple use-case of Spring JPA

maven dependency for spring jpa

`<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>`

**Use cases covered**

1. How to achieve Joins in Spring JPA

@OneToMany

If you have one to many relation such as :
`One Department Multiple Employees.`

`One User multiple user activities.`

`Identify the join column between tables.`
`add below code to Users table:`
```@Entity
@Table(name = "users")
@Data
public class Users {

@EqualsAndHashCode.Exclude
@ToString.Exclude
@OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
private Set<UserActivity> useractivity;

add below code to UserActivity table:`

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "user_id", insertable = false, updatable = false)
private Users users;









