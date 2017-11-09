# acdm

Requirements:
1. Any Debian or Ubuntu flavor OS\
2. Maven (https://maven.apache.org/download.cgi)\
3. Git (https://git-scm.com/)\
4. Apache Solr\

Installation\
wget http://www-eu.apache.org/dist/lucene/solr/7.1.0/solr-7.1.0.tgz\
tar -zxvf solr-7.1.0.tgz\
cd solr-7.1.0/bin\
sudo ./solr start -p 8983 -force\
sudo ./solr create -c booklist -force\
~> go to Booklist.json folder\
curl 'http://localhost:8983/solr/booklist/update?commit=true' --data-binary @Booklist.json -H 'Content-type:application/json'\
~> to test the import is successful\
curl 'http://localhost:8983/solr/booklist/select?q=*:*&rows=10'\

#will be updated

