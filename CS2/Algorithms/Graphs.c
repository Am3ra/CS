#include <stdio.h>
#include <stdbool.h>
#include <LinkedList.h>

typedef struct GraphNodeStruct
{
    int value;
    Node *adjacencyListHead;
} GraphNode;

typedef struct AdjacencyStruct
{
    bool visited;
    int distance;
    GraphNode * father;
} Adjacency;

GraphNode * CreateGraphNode(int value, Node * AdjacencyList){

}


Node * BFS_Graph(GraphNode * root){
    Node * root = CreateNode(root);
}

