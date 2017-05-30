#include<iostream>

using namespace std;

class MyClass{

	public:
		MyClass(){
			regVar = 10;
		}
		~MyClass(){
			cout<< regVar<<endl;
		}
	private:
		int regVar;
	friend void print(MyClass &obj);
};

void print(MyClass &obj){
	obj.regVar = 20;
}

int main(){
	MyClass myClass;
	print(myClass);
	return 0;
}
