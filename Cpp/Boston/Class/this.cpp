#include<iostream>

using namespace std;

class MyClass{

	public:
		MyClass(int a)
		:num(a){
		}
		void print(){
			cout << "num = " << num << endl;
			cout << "this->num = " << this->num << endl;
			cout << "(*this).num = " << (*this).num << endl;
		}
	private:
		int num;
};

int main(){

	MyClass myClass(5);
	myClass.print();
	return 0;
}
