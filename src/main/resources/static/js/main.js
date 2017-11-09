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