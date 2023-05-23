# CartChef: The Smart Grocery Cart Recipe Companion

CartChef is an intelligent and user-friendly service that simplifies meal planning and enhances your grocery shopping experience. With a seamlessly integrated backend developed using Spring Boot in Java and a dynamic demo frontend built with React, 
CartChef analyzes the items you've already selected and provides intelligent suggestions for additional ingredients needed to complete mouthwatering recipes. It provides a convenient solution for users to select groceries, discover matching recipes, and receive tailored suggestions for additional ingredients.

## Key Features

1. **User-Friendly Interface**: The React-based frontend was made to showcase product capabilities in a visually appealing and intuitive user interface. Users could easily navigate through the dummy store, select groceries, and proceed to checkout.

2. **Matching Recipes**: CartChef utilized the powerful theMealDB API to find the best matching recipes based on the available ingredients in the user's cart. By considering the items in the cart and disregarding common pantry items, such as oil or butter, CartChef ensured the suggested recipes are feasible and practical.

3. **Additional Ingredients Suggestions**: During checkout, CartChef analyzed the selected groceries and intelligently recommended up to three additional ingredients required to complete the chosen recipe.

4. **Maximized Recipe Selection**: CartChef's backend implements a controller-service architecture in Spring Boot, providing a robust foundation. By leveraging this architecture, the backend efficiently communicates with theMealDB API to retrieve recipe details and selects the best matching recipe based on the available ingredients. CartChef prioritizes recipes that require a maximum of three additional ingredients, optimizing users' cooking experience.

5. **Independent Backend on Google Cloud**: The backend of CartChef was deployed on Google Cloud's App Engine, ensuring its independence and flexibility for integration with various grocery stores. This was to allow seamless integration with multiple stores, enabling users to utilize CartChef's functionality across different platforms.

## How it Works

The frontend makes API calls to the CartChef backend, which processes the requests and communicates with theMealDB API to find matching recipes. The backend employs an intelligent algorithm to select the best recipe based on the available ingredients in the user's store. The response, containing recipe and item details, is sent back to the frontend in JSON format, providing users with a personalized and tailored experience.

CartChef is your trusted culinary companion, combining technology and creativity to simplify your meal planning and shopping journey. Explore new recipes, make informed grocery choices, and elevate your cooking skills with CartChef.

## Motivation and Business 

CartChef provides a convenient solution for users to select groceries, discover matching recipes, and receive tailored suggestions for additional ingredients. It was meant to increase customer satisfaction while increasing revenue.

1. **Enhanced Customer Experience**: CartChef provides a seamless and user-friendly platform for customers to plan their meals and complete their grocery shopping. By offering personalized recipe suggestions and additional ingredient recommendations, CartChef enhances the overall customer experience, making it easier and more enjoyable for users to cook delicious meals.

2. **Increased Customer Engagement**: With CartChef, customers can discover new recipes and explore culinary possibilities, resulting in increased engagement and time spent within the application. By offering a wide range of recipe options and suggesting complementary ingredients, CartChef keeps users actively involved, driving repeat usage and customer loyalty.

3. **Streamlined Grocery Shopping**: By integrating with the user's grocery cart and intelligently suggesting additional ingredients, CartChef simplifies the shopping process. Customers can quickly identify and add missing items to their cart, eliminating the need for multiple store visits and reducing the likelihood of forgotten ingredients. This streamlined shopping experience saves customers time and effort, resulting in increased satisfaction and efficiency.

4. **Revenue Generation Opportunities**: CartChef can create revenue generation opportunities through partnerships with grocery stores. By integrating with multiple stores, CartChef can provide users with a seamless experience and expand its user base. Additionally, through strategic collaborations and promotions, CartChef can generate revenue through affiliate marketing, sponsored recipes, or advertising partnerships with relevant brands.

5. **Data-Driven Insights**: CartChef collects valuable data on user preferences, popular recipes, and ingredient trends. This data can be leveraged to gain insights into customer behavior, identify emerging culinary trends, and make data-driven business decisions. These insights can be utilized to enhance the user experience, tailor marketing campaigns, and improve overall operational efficiency.

6. **Scalability and Integration**: With its independent backend deployed on Google Cloud's App Engine, CartChef is designed for scalability and seamless integration with various grocery stores. This flexibility allows CartChef to adapt to changing market dynamics, integrate with new partners, and expand its reach, providing a versatile solution that can grow with the business.

7. **Competitive Differentiation**: CartChef sets itself apart from traditional grocery and recipe applications by providing a holistic solution that combines meal planning, grocery shopping, and recipe suggestions in one platform. This unique value proposition positions CartChef as an innovative and comprehensive tool for users, differentiating it from competitors and attracting a wider audience.

Overall, CartChef offers significant business advantages by enhancing the customer experience, streamlining grocery shopping, generating revenue opportunities, and providing valuable data insights.


### Acknowledgments

This project was developed as a part of NCR Hackathon as a team of 4 students. Thank you to Stella Yie and Ekisha for developing the frontend, and Alex for assiting me in Backend development
