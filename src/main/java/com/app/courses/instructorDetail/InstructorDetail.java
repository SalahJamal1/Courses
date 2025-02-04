package com.app.courses.instructorDetail;

import com.app.courses.instructor.Instructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "youtube_channel")
    private String youtube_channel;
    @Column(name = "hobby")
    private String hobby;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "instructorDetail")
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "hobby='" + hobby + '\'' +
                ", youtube_channel='" + youtube_channel + '\'' +
                ", id=" + id +
                '}';
    }
}
