#include<iostream>

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

