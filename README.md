# Presto
This is test project for Presto.

- This Project is using Flickr API to fetch the Images and its meta data.
  1. flickr.photos.search  --> Getting Photo Id and Title
  2. flickr.photos.getSizes -- > Using above PhotoId, Getting Image url, Dimension and Size.
  
- Technologies used in this Project

  1. **Retrofit** --> Retrofit is an awesome type-safe HTTP client for Android and Java built by awesome folks at Square. Retrofit makes it easy to consume JSON or XML data which is parsed into Plain Old Java Objects (POJOs).
  2. **Glide** --> This library is used to load images very effieicenty.
  
- I was getting issue while fetching data using given API_KEY. So I have created/Requetsed new API_KEY and used in this project.
  All the API_KEY,AUTH, and API_SIG is defined in **gradle.properties** file.
  
  **API_KEY=d81a384144084d2638d8ee136cc0398a**
  
  **AUTH=72157673388168278-9fd7b2cafb42b02f**
  
  **API_SIG=1c532783034c421591544d7cbf9e65dd**
  
  - If you are having issue with getting response from API, You can use your credentials.You don't need to change anything in code.

  
