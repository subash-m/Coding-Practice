#include<iostream>

int main(){
	double nan = 0.0 / 0.0;
	std::cout<< 1.0/0.0 <<std::endl;
	std::cout<< -1.0/0.0 <<std::endl;
	std::cout<< nan <<std::endl;

	std::cout<< 146000 <<std::endl;
	std::cout<< 146000.001f <<std::endl;

	return 0;
}
