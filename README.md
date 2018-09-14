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
  
  **API_KEY=1f14c84d869d4c8698271c799544808c**
  
  **AUTH=72157699739951311-e5a776ac9b5e6b39**
  
  **API_SIG=0a1af9993594399b27f5bbd0a0b375aa**
  
  - If you are having issue with getting response from API, You can use your credentials.You don't need to change anything in code.
  - It seems like API_KEY, AUTH,and API_SIG expires after few hours.So When you test this project, make sure you update all above credentials in gradle.properties file.
  - Minor UI adujstment can be achived with minimum effort.

  
