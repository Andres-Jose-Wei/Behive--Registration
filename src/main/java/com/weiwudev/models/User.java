package com.weiwudev.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    /**
     * A user’s id
     */
    private String id;

    /**
     * A user’s username
     */
    private String username;

    private String password;

    /**
     * A user’s email
     */
    private String email;
    /**
     * A user’s first name
     */
    private String firstName;
    /**
     * A user’s last name
     */
    private String lastName;


    private double overallRating;
    /**
     * A user’s personal skill rating
     */
    private double personalSkillAvg;
    /**
     * A user’s technical skill rating
     */
    private double technicalSkillAvg;

    /**
     * The percentage of how many times a user completed all their tasks on time
     */
    private double punctuality;
    /**
     * The number of reviews for a user
     */
    private int reviewsCount;
    /**
     * The number of unique reviewers for a user
     */
    private int uniqueReviewersCount;
    /**
     * The number of times a user was awarded “Most Valuable Programmer” of their
     * team after their project was completed
     */
    private int mvpCount;
    /**
     * The number of projects a user worked on
     */
    private int projectCount;
    /**
     * Whether or not a user is already working on a project
     */
    private boolean isAvailable;
}