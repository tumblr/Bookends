# Bookends

A UI widget that allows for headers and footers on lists backed by [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html), for Android.


## Usage

Bookends wraps an adapter that you give it. 

It works by creating extra view items types that are returned in `getItemViewType()`, and mapping these to the header and footer views provided via `addHeader()` and `addFooter()`.

There are some restrictions when using this class:

1. Bookends only works for single-column lists. (ie, those that use [LinearLayoutManager](https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html)).

2. The base adapter can't use negative view types, since Bookends uses negative view types to keep track of header and footer views.

3. You can't add more than 1000 headers or footers.

Example:

```java
// Create your views, whatever they may be
View myHeader = LayoutInflater.from(getContext()).inflate(R.layout.my_header, null);
View anotherHeader = LayoutInflater.from(getContext()).inflate(R.layout.another_header, null);
View myFooter = LayoutInflater.from(getContext()).inflate(R.layout.my_footer, null);

// Add them as headers / footers
Bookends<MyAdapter> adapter = new Bookends<MyAdapter>(myAdapter);
adapter.addHeader(myHeader);
adapter.addHeader(anotherHeader);
adapter.addFooter(myFooter);
```

## Sample app
Clone and build this repo in Android Studio to see an example of a sample app. The app makes a list with RecyclerView and uses Bookends to add header and footer views.

## Contact

Michael Lapadula: mlapadula@tumblr.com

## License

Copyright 2015 Tumblr, Inc.

Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
