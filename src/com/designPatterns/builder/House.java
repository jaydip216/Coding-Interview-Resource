package com.designPatterns.builder;

public class House {
    private Integer rooms;
    private Integer bathrooms;
    private Integer parkingSpaces;
    private Boolean hasGarden;
    private Boolean hasSwimmingPool;
    private Integer floors;

    private House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.parkingSpaces = builder.parkingSpaces;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.floors = builder.floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                ", bathrooms=" + bathrooms +
                ", parkingSpaces=" + parkingSpaces +
                ", hasGarden=" + hasGarden +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", floors=" + floors +
                '}';
    }

    public static class HouseBuilder {
        private int rooms;
        private int bathrooms;
        private int parkingSpaces;
        private boolean hasGarden;
        private boolean hasSwimmingPool;
        private int floors;

        public HouseBuilder rooms(int rooms){
            this.rooms = rooms;
            return this;
        }

        public HouseBuilder bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public HouseBuilder parkingSpaces(int parkingSpaces) {
            this.parkingSpaces = parkingSpaces;
            return this;
        }

        public HouseBuilder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder hasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder floors(int floors) {
            this.floors = floors;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
