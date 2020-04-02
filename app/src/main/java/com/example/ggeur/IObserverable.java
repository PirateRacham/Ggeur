package com.example.ggeur;

public interface IObserverable {
    void addObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyObservers();
}
