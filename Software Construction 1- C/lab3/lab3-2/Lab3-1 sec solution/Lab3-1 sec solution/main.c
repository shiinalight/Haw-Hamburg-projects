#include <stdio.h>
#include <math.h>

#define EARTH_RADIUS 6378.388  // Earth's radius in kilometers

// Function to convert degrees to radians
double toRadians(double degrees) {
    return degrees * M_PI / 180.0;
}

// Function to calculate local distance (formula 15.3)
double localDistanceKm(double lat1, double lon1, double lat2, double lon2) {
    double deltaLat = fabs(lat1 - lat2) * 111.3;                                                   // Difference in latitude in km
    double avgLat = (lat1 + lat2) / 2.0;                                                                  // Average latitude
    double deltaLon = fabs(lon1 - lon2) * 111.3 * cos(toRadians(avgLat));  // Adjusted longitude difference
    return sqrt(deltaLat * deltaLat + deltaLon * deltaLon);                                 // Pythagorean theorem
}

// Function to calculate global distance (formula 15.4)
double distanceKm(double lat1, double lon1, double lat2, double lon2) {
    // Convert degrees to radians
    lat1 = toRadians(lat1);
    lon1 = toRadians(lon1);
    lat2 = toRadians(lat2);
    lon2 = toRadians(lon2);

    // Apply formula (15.4)
    double cosineAngle = sin(lat1) * sin(lat2) +
                         cos(lat1) * cos(lat2) * cos(lon2 - lon1);
    return EARTH_RADIUS * acos(cosineAngle);
}

int main(void) {
    // Locations and their coordinates (Table 15.1)
    const char *locations[] = {
        "HAW Hamburg", "Eiffel Tower", "Palma de Mallorca",
        "Las Vegas", "Copacabana", "Waikiki Beach", "Surfer's Paradise"
    };
    double latitudes[] = {53.557078, 48.858363, 39.562553, 36.156214, -22.971177, 21.281004, -28.002695};
    double longitudes[] = {10.023109, 2.294481, 2.661947, -115.148736, -43.182543, -157.837456, 153.431781};

    int numLocations = sizeof(latitudes) / sizeof(latitudes[0]);

    // Reference point: HAW Hamburg (index 0)
    double refLat = latitudes[0];
    double refLon = longitudes[0];

    // Calculate and print distances
    printf("Distances to HAW Hamburg:\n");
    printf("%-20s %-15s %-15s\n", "Location", "Local Distance (km)", "Global Distance (km)");
    for (int i = 1; i < numLocations; i++) {
        double localDist = localDistanceKm(refLat, refLon, latitudes[i], longitudes[i]);
        double globalDist = distanceKm(refLat, refLon, latitudes[i], longitudes[i]);
        printf("%-20s %-15.2f %-15.2f\n", locations[i], localDist, globalDist);
    }

    return 0;
}

