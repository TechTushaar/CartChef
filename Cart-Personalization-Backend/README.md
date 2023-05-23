# CartChef Backend

This repository contains the backend codebase for the CartChef application. The backend is developed using Spring Boot in Java, providing robust and scalable functionality to power the CartChef ecosystem.

## Key Features

- **Client-Controller-Service Model**: The backend follows a client-controller-service architectural pattern, promoting separation of concerns and modular code organization. This allows for better maintainability, testability, and extensibility of the application.

- **Integration with theMealDB API**: The backend makes API calls to theMealDB API to find matching recipes based on the user's selected groceries. It intelligently selects the best matching recipe considering the available ingredients and suggests additional items needed to complete the recipe.

- **Independent Deployment on Google Cloud**: The backend is deployed on Google Cloud's App Engine, enabling independence and flexibility in integrating with multiple grocery stores. This architecture ensures seamless integration across various platforms and allows CartChef to scale effortlessly.

## Getting Started

To get started with the CartChef Backend, follow these steps:

1. Clone this repository to your local machine.
2. Ensure you have Java and Spring Boot installed.
3. Set up the necessary API keys for theMealDB API integration.
4. Configure the backend application properties to connect with theMealDB API and any other required dependencies.
5. Build and run the application using your preferred IDE or command line tools.

## Acknowledgments

We would like to express our gratitude to theMealDB API for providing the extensive recipe database that powers the CartChef Backend. We also extend our thanks to the open-source community for their invaluable contributions and support.

Thank you for using CartChef Backend! Together, let's simplify meal planning and revolutionize the grocery shopping experience.
