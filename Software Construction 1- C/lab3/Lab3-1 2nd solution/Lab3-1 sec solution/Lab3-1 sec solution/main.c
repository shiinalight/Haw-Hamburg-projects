#include <stdio.h>
#include <stdbool.h>

// Function to check if the location is in the Northern Hemisphere
bool isNorthernHemisphere(double latitude) {
    return latitude > 0;
}

// Function to check if the location is in the Southern Hemisphere
bool isSouthernHemisphere(double latitude) {
    return latitude < 0;
}

int main(void) {
    // Test coordinates (locations)
    double latitudes[] = {53.557078, 48.858363, -22.971177, 21.281004, -28.002695, 0.0};
    const char *locations[] = {
        "HAW Hamburg", "Eiffel Tower", "Copacabana",
        "Waikiki Beach", "Surfer's Paradise", "Equator"};
    int numCoordinates = sizeof(latitudes) / sizeof(latitudes[0]);

    // Loop through the coordinates and test
    printf("Testing Hemispheres:\n\n");
    for (int i = 0; i < numCoordinates; i++) {
        double latitude = latitudes[i];
        printf("Location: %s\n", locations[i]);
        printf("Latitude: %.6f\n", latitude);

        if (isNorthernHemisphere(latitude)) {
            printf("  -> This location is in the Northern Hemisphere.\n");
        } else if (isSouthernHemisphere(latitude)) {
            printf("  -> This location is in the Southern Hemisphere.\n");
        } else {
            printf("  -> This location is on the Equator.\n");
        }
        printf("\n");
    }

    return 0;
}

