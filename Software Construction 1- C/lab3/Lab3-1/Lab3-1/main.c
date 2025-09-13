#include <stdio.h>
#include <stdbool.h>

// Function to check if a location is in the Northern Hemisphere
bool isNorthernHemisphere(double latitude) {
    return latitude > 0;
}

// Function to check if a location is in the Southern Hemisphere
bool isSouthernHemisphere(double latitude) {
    return latitude < 0;
}

int main() {
    // Test coordinates
    double testCoordinates[] = {45.0, -30.5, 0.0, 10.5, -90.0};
    int numCoordinates = sizeof(testCoordinates) / sizeof(testCoordinates[0]);

    // Testing the functions
    for (int i = 0; i < numCoordinates; i++) {
        double latitude = testCoordinates[i];
        printf("Latitude: %.2f\n", latitude);
        if (isNorthernHemisphere(latitude)) {
            printf("  -> This location is in the Northern Hemisphere.\n");
        } else if (isSouthernHemisphere(latitude)) {
            printf("  -> This location is in the Southern Hemisphere.\n");
        } else {
            printf("  -> This location is on the Equator.\n");
        }
    }

    return 0;
}

