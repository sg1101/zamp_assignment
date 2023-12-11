# zamp_assignment
For the scope of local development of this assignment I have created a Java based application and have created two tries for searching. One trie is based on phone number and the other trie stores the name. The new contacts are stored using contact object which contains all the details like firstname, lastname, address and phone number. The tries save the contacts reference. Since I am using trie to save the data there is a added functionality ,the search result is giving a list of results which have the prefix matching with provided input.

I have used trie because it is a efficient way of storing and retrieving data. For this type of data it makes the most sense to use a trie. This has been done since use of inbuilt functions and database was not allowed.

To further scale this design we can shard it and have different shards for example - one of the name trie shard can have names starting from A to D.

For a prod level application using a nosql db like dynamodb and cassandra makes more sense. Or if we want to use a relational db then we can do indexing on the name and the phone number.