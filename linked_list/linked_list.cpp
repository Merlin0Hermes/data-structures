#include <iostream>

typedef struct Node
{
	int data;
	Node *next;
};

void insert_end(Node*& head, int value)
{
	Node *new_node = new Node;
	new_node->next = nullptr;
	new_node->data = value;

	if (head == nullptr)
	{
		head = new_node;
		return;
	}

	Node *temp = head;
	while (temp->next != NULL)
	{
		temp = temp->next;
	}
	temp->next = new_node;
}

int main()
{
	Node *head = NULL;

	return 0;
}