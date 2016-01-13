package models;

/**
 * @author Dominic Dahnelt
 */

public class CpuPlayerModel extends AbstractPlayerModel {

    /** Public Constructor */
    public CpuPlayerModel(String name) {
        super(name);
    }

    /**
     * Get the random choice of the CPU-Player
     * 
     * @returns choice of CPU-Player
     */
    public int getCpuChoice() {
        int cpuChoice;
        double random = Math.random() * 5;
        cpuChoice = (int) random + 1;
        return cpuChoice;
    }

}
