const url = '/books?author=';

var data = {
	title: 'Mini Search engine',
	toggleDDL: false,
	searchTerm: '',
	receivedBooks: [],
	results:[],
	iter:null,
}

new Vue({
	el: '#app',
	data: data,
	mounted: function () {
		this.receivedBooks = [{"id":"0439dee6-cff4-4b42-909f-66c3facd5f48","author":"Ava Gray","series":"Skin","name":"Skin Game"},{"id":"87e8a3c0-1f72-4128-8803-8d872fe8ebd8","author":"Alasdair Gray","series":null,"name":"Lanark: A Life in Four Books"},{"id":"c20356a7-db42-4e52-b040-6340c5e9a673","author":"Emily Gray Tedrowe","series":null,"name":"Commuters: A Novel"}];
		this.toggleDDL = false;
		this.results =  this.receivedBooks;
	},
	watch: {
		searchTerm: function (val) {
			if(val.length == 0){
				this.results = [];
			}
		}
	},
	methods:{
		searchBooks: function(){
			var obj = this;
			if (obj.searchTerm.length > 0){
				axios.get(url+obj.searchTerm)
				.then(function (response) {
					console.log(response.data);
					var result = response.data;
					if (typeof result.error === 'undefined'){
						obj.receivedBooks = result;
						obj.toggleDDL = true;
					} else {
						obj.toggleDDL = false;
					}
					
				})
				.catch(function (error) {
					console.log(error);
					obj.toggleDDL = false;
				});
			} else {
				obj.toggleDDL = false;
			}
			
		},
		displayResult: function(){
			if (this.iter==null){
				this.results = this.receivedBooks;
			} else {
				this.results = [];
				this.results.push(this.receivedBooks[this.iter]);
			}
			this.toggleDDL = false;
			this.iter = null;
		},
		selectItem: function(item){
			this.results = [];
			this.results.push(item);
			this.toggleDDL = false;
			this.iter = null;
		},
		cursorDown: function(){
			console.log(this.iter < this.receivedBooks.length - 1);
			if (this.iter == null){
				this.iter = 0
			} else if(this.iter < this.receivedBooks.length - 1){
				this.iter++;
			}
	        console.log(this.iter);
		},
		cursorUp: function(){
			console.log(this.iter);
			if(this.iter > 0){
				this.iter--;
			}
			console.log(this.iter);
		},
		isActive(index) {
	        return index === this.iter;
	    },
	}
})