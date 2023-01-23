package com.canislupus.CanisLupus.Domain;

import java.util.Objects;

import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Audited
@Entity(name = "Course")
@Table(name = "courses")
public class Course extends Padre{
    
    // @OneToMany(mappedBy = "course",
    //             cascade = CascadeType.ALL,
    //             orphanRemoval = true)
    // private List<Kardex_Course2> kardexs =  new ArrayList<>();

    @NotEmpty
    private String ssName;
    @NotEmpty
    private Integer credits;
    @NotEmpty
    private Integer maxAttempts;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Carrer carrer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArea")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOptional")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Optionalx optionals;


    // public void addTag(Tag tag) {
    //     PostTag postTag = new PostTag(this, tag);
    //     tags.add(postTag);
    //     tag.getPosts().add(postTag);
    // }
 
    // public void removeTag(Tag tag) {
    //     for (Iterator<PostTag> iterator = tags.iterator();
    //          iterator.hasNext(); ) {
    //         PostTag postTag = iterator.next();
             
    //         if (postTag.getPost().equals(this) &&
    //                 postTag.getTag().equals(tag)) {
    //             iterator.remove();
    //             postTag.getTag().getPosts().remove(postTag);
    //             postTag.setPost(null);
    //             postTag.setTag(null);
    //         }
    //     }
    // }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(super.getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }
}