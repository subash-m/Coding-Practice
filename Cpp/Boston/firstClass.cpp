#include<iostream>
#include<string>

using namespace std;

class MyClass{

	private:
		string name;
	public:
		MyClass(string x){
			setName(x);
			cout<<"Class is Initialized\n";
		}
		void setName(string x){
			name = x;
		}

		string getName(){
			return name;
		}

		void print(){
			cout << "Subash The Boss\n";
		}

};

int main(){

	MyClass myClass("Subash The Name\n");
	cout<< myClass.getName();
	return 0;
}
