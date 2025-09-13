#include <stdio.h>
#include <math.h>

double distanceKm(double latitude1, double longitude1, double latitude2, double longitude2) {
    // Earth's radius in kilometers
    const double EARTH_RADIUS = 6378.388;

    // Convert latitude and longitude from degrees to radians
    latitude1 = latitude1 * M_PI / 180.0;
    longitude1 = longitude1 * M_PI / 180.0;
    latitude2 = latitude2 * M_PI / 180.0;
    longitude2 = longitude2 * M_PI / 180.0;

    // Calculate differences
    double deltaLatitude = latitude2 - latitude1;
    double deltaLongitude = longitude2 - longitude1;

    // Calculate distance using the Haversine formula
    double a = sin(deltaLatitude / 2) * sin(deltaLatitude / 2) +
               cos(latitude1) * cos(latitude2) * sin(deltaLongitude / 2) * sin(deltaLongitude / 2);
    double c = 2 * atan2(sqrt(a), sqrt(1 - a));

    // Calculate the distance in kilometers
    double distance = EARTH_RADIUS * c;

    return distance;
}

int main(void) {
    // Example usage:
    double lat1 = 40.7128;
    double lon1 = -74.0060; // New York City
    double lat2 = 34.0522;
    double lon2 = -118.2437; // Los Angeles

    double distance = distanceKm(lat1, lon1, lat2, lon2);

    printf("Distance between New York City and Los Angeles: %.2f km\n", distance);

    return 0;
}
