# CheckYourIQ
1.First add code give below in app:gradle file
  dataBinding{
    enabled = true
    }
2. Create fragment
3. Add <layout></layout>to the out most tags of all layout files
4. In MainActivity we use DataBindingUtil.setContentView() to get binding class from layout
5. In title_fragment we cannot call setContentView() so we have to use DataBindingUtil.inflate()
