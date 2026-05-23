# monte-carlo
*A simulation to solve 3b1b ring loop puzzle*

This simulation was done to solve a puzzle featured in Grant Sanderson's latest puzzle of the month linked here : https://youtube.com/shorts/ZHXt0-_gSj4?si=yIWiOG5TqQmQLQr2

The problem looked very monte carlo-able and I just wanted to code for recreation.
I just created constructs to simulate randomly picking up strings and tying them together.

Shuffled a list of 100 integers to simulate ends of strings.
Maintained a map telling which end is connected to which end.
Picked up two ends at random and connected them together in the map by updating new ends.

The value turned out to be 2.938794 which i guess after reading theory is close to the 2.9377 true answer.

<img width="438" height="122" alt="image" src="https://github.com/user-attachments/assets/2f462a37-a6bf-4af5-8a8b-e1fe8b86e0f6" />
