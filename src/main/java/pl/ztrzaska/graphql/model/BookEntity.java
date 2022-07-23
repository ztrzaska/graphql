package pl.ztrzaska.graphql.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PAGE_COUNT")
    private Integer pageCount;

    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID", nullable = false)
    private AuthorEntity author;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;
}
