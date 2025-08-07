Feature: Homework

	Background:
	Given url 'https://conduit-api.bondaracademy.com/api'
	* def token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjozMTE3Mn0sImlhdCI6MTc1NDA2MTQ2NiwiZXhwIjoxNzU5MjQ1NDY2fQ.VhzGCDE3SXHkc4SKjt8OwdHVU8A7rNq_zxKV1-NWkJQ'
	
	Scenario: Fav articles
	Given header Authorization = 'Token '+ token
  	Given path 'articles'
  	Given params {limit:10,offset:0}
  	When method Get
  	Then status 200
	* def slug = response.articles[0].slug
	* def favCount = response.articles[0].favoritesCount
	
	Given header Authorization = 'Token ' + token
	Given path 'articles',slug,'favorite'
	And request {}
	When method Post
	Then status 200
	And match response.article.favoritesCount == 1
	
	Given header Authorization = 'Token '+ token
  	Given path 'articles'
  	Given params {favorited:KarateTestDemo,limit:10,offset:0}
  	When method Get
  	Then status 200
  	And match response.articles[*].slug contains slug
  	
  	#Homework2
  	Given header Authorization = 'Token '+ token
  	Given path 'articles'
  	Given params {limit:10,offset:0}
  	When method Get
  	Then status 200
  	* def slug1 = response.articles[0].slug
  	
  	Given header Authorization = 'Token '+ token
  	Given path 'articles',slug,'comments'
  	And request {comment: {body: "bla vla"}}
  	When method Post
  	Then status 200
  	And match response.comment.body == "bla vla"
  	* def id = response.comment.id
  	
  	Given header Authorization = 'Token '+ token
  	Given path 'articles',slug,'comments'
  	When method Get
  	Then status 200
  	* def comment = response.comments
  	* def count = karate.sizeOf(comment)
	* print 'Total comments:', count
  	And match count == 3
  	
  	Given header Authorization = 'Token '+ token
  	Given path 'articles',slug,'comments',id
  	When method Delete
  	Then status 200
  	
  	Given header Authorization = 'Token '+ token
  	Given path 'articles',slug,'comments'
  	When method Get
  	Then status 200
  	* def comment = response.comments
  	* def count = karate.sizeOf(comment)
	* print 'Total comments:', count
  	And match count == 2