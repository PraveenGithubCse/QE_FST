Feature: Create, Get, Delete request

Background:
  Given url 'https://conduit-api.bondaracademy.com/api'
  * def token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjozMTE3Mn0sImlhdCI6MTc1Mzk1MDE2NywiZXhwIjoxNzU5MTM0MTY3fQ.qN24Af6LNC7hd-HihNrRzNmoc5jSo_sp0-u8HniTBrM'
  #data driven testing
  * def articleBody = read('classpath:DataDrivenDemo/articles.json')
  * def dataGen = Java.type('Helpers.DataGenerator')
  * def bodyData = dataGen.body()
  * set articleBody.article.title = bodyData.title
  * set articleBody.article.description = bodyData.description
  * set articleBody.article.body = bodyData.body

@createndelete
Scenario: Create article
  Given header Authorization = 'Token ' + token
  Given path 'articles'
  And request articleBody
  When method Post
  Then status 201
  And match response.article.title == articleBody.article.title
  * def slug = response.article.slug

  Given header Authorization = 'Token ' + token
  Given path 'articles', slug
  Given params {limit:10,offset:0}
  When method Get
  Then status 200
  And match response.article.title == articleBody.article.title

  Given header Authorization = 'Token ' + token
  Given path 'articles', slug
  When method Delete
  Then status 204
  
  Given header Authorization = 'Token ' + token
  Given path 'articles'
  Given params {limit:10,offset:0}
  When method Get
  Then status 200
  And match response.articles[*].title !contains articleBody.article.title
