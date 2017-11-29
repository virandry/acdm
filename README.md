# Book Search Web Service & Client

## Main Tech
1. Spring Boot (https://github.com/virandry/search-backend)
2. VueJS 2 (https://github.com/virandry/search-vue) 
3. ReactJS (https://github.com/virandry/search-react)

## Preview (Scrolldown for Guideline)
1. select book from the list by click
2. select book from the list by navigating using arrow and enter (return)
3. search by author
![alt text](https://image.ibb.co/hJ1efw/qrr.gif)

## Requirements:
1. Any Debian or Ubuntu flavor OS
2. Maven (https://maven.apache.org/download.cgi)
3. Git (https://git-scm.com/)
4. Apache Solr 7.1.0 (SE -indexed - NoSQL - Document)
5. Node JS and NPM
6. curl
7. Book Search Web Service source code <https://github.com/virandry/search-acdm.git>
8. Book Search Client source code <https://github.com/virandry/search-vue.git>

## Installation
### Apache Solr
``` bash
# Before()
cd /opt/
mkdir search
cd search

# Download
wget http://www-eu.apache.org/dist/lucene/solr/7.1.0/solr-7.1.0.tgz
tar -zxvf solr-7.1.0.tgz
cd solr-7.1.0/bin

# Start Solr at Port 8983 in force mode and create booklist document
sudo ./solr start -p 8983 -force
sudo ./solr create -c booklist -force
```
### Book Search Web Service Deployment and Solr Data Import (Booklist.json)
``` bash
# Before()
cd /opt/search

# Retrieve Book Search Web Service source code
git clone https://github.com/virandry/search-acdm.git
cd search-acdm
curl 'http://localhost:8983/solr/booklist/update?commit=true' --data-binary @Booklist.json -H 'Content-type:application/json'

# Test Inserted Data
curl 'http://localhost:8983/solr/booklist/select?q=*:*&rows=10'

# Deployment of Web Service
## The web service is packaged as WAR file (not JAR) as previously I combined the static files in this package
## After that I make the front end code standalone and run it in nodejs environment
mvn clean install spring-boot:run

# To test the web service
go to http://localhost:1110/books?author=terry
```
### Book Search Client Deployment - VueJS 2
``` bash
# Before()
cd /opt

# Retrieve Book Search Client source code
git clone https://github.com/virandry/search-vue.git

# installing Webpack globally and install project dependencies
npm install webpack -g
npm install

# Serve with hot reload at localhost:2222
SET PORT=2222
npm run dev

go to localhost:2222
```

### Book Search Client Deployment - ReactJS
``` bash
# Before()
cd /opt

# Retrieve Book Search Client source code
git clone https://github.com/virandry/search-react.git

# installing Webpack globally and install project dependencies
npm install

# Serve
npm start

```
