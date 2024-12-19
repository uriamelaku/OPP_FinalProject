package Users;

import system.CourseSystem;

/**
 * The interface representing an active participant in the educational system.
 */
public interface Active {
    /**
     * Gets the ID of the active participant.
     *
     * @return The ID of the active participant.
     */
    int getId();

    /**
     * Gets the full name of the active participant.
     *
     * @return The full name of the active participant.
     */
    String getFullName();

    /**
     * Gets the type of the active participant.
     *
     * @return The type of the active participant.
     */
    String ActiveType();

    /**
     * Sets the full name of the active participant.
     *
     * @param fullName The full name to set for the active participant.
     */
    void setFullName(String fullName);

    /**
     * Sets the course system for the active participant.
     *
     * @param system The course system to set for the active participant.
     */
    void setSystem(CourseSystem system);

    /**
     * Gets the name of the course system associated with the active participant.
     *
     * @return The name of the course system associated with the active participant.
     */
    String getSysName();
}

