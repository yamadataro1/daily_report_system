package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "likes")
@NamedQueries({
    @NamedQuery(
        name = "getAllLikes",
        query = "SELECT l FROM Like AS l ORDER BY l.id DESC"
    ),
    @NamedQuery(
        name = "getLikesCount",
        query = "SELECT COUNT(l) FROM Like AS l"
    ),

    @NamedQuery(
            name = "getEmployeesWhoLiked",
            query = "SELECT l FROM Like AS l WHERE l.report.id = :report ORDER BY l.id DESC"
        ),

    @NamedQuery(
            name = "getEmployeesWhoLikedCount",
            query = "SELECT COUNT(l) FROM Like AS l WHERE l.report.id = :report"
        )
})
@Entity
public class Like {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "like_created_at", nullable = false)
    private Timestamp like_created_at;

    @Column(name = "like_updated_at", nullable = false)
    private Timestamp like_updated_at;

    @ManyToOne
    @JoinColumn(name = "like_employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "like_report_id", nullable = false)
    private Report report;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLike_created_at() {
        return like_created_at;
    }

    public void setLike_created_at(Timestamp like_created_at) {
        this.like_created_at = like_created_at;
    }

    public Timestamp getLike_updated_at() {
        return like_updated_at;
    }

    public void setLike_updated_at(Timestamp like_updated_at) {
        this.like_updated_at = like_updated_at;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }



}
