package com.example.trialtask.model.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "date_of_create")
    private LocalDateTime dataOfCreate;

    @UpdateTimestamp
    @Column(name = "date_of_change")
    private LocalDateTime dateOfChange;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL)
    private Set<Vote> votes = new HashSet<>();

}
